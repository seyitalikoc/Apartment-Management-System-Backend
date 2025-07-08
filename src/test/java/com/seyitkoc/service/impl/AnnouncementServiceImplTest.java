package com.seyitkoc.service.impl;

import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.*;

import com.seyitkoc.dto.announcement.DtoAnnouncement;
import com.seyitkoc.dto.announcement.DtoAnnouncementIU;
import com.seyitkoc.entity.Announcement;
import com.seyitkoc.entity.Apartment;
import com.seyitkoc.entity.Building;
import com.seyitkoc.common.exception.ApplicationException;
import com.seyitkoc.common.exception.ErrorMessage;
import com.seyitkoc.common.exception.MessageType;
import com.seyitkoc.mapper.AnnouncementMapper;
import com.seyitkoc.repository.AnnouncementRepository;
import com.seyitkoc.common.security.JwtTokenService;
import com.seyitkoc.service.IApartmentAnnouncementService;
import com.seyitkoc.service.IApartmentService;
import com.seyitkoc.service.IBuildingService;
import com.seyitkoc.service.IUserService;
import com.seyitkoc.specification.AnnouncementSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

class AnnouncementServiceImplTest {
    private AnnouncementServiceImpl announcementService;

    private AnnouncementMapper announcementMapper;
    private AnnouncementRepository announcementRepository;
    private IBuildingService buildingService;
    private IApartmentService apartmentService;
    private IApartmentAnnouncementService apartmentAnnouncementService;
    private IUserService userService;
    private JwtTokenService jwtTokenService;
    private AnnouncementSpecification announcementSpecification;

    String token = "testToken";
    String email = "test@test.com";
    Announcement announcement;
    DtoAnnouncementIU dtoAnnouncementIU;
    DtoAnnouncement dtoAnnouncement;
    Building building;
    List<Apartment> apartments;

    @BeforeEach
    void setUp() {
        announcementMapper = mock(AnnouncementMapper.class);
        announcementRepository = mock(AnnouncementRepository.class);
        buildingService = mock(IBuildingService.class);
        apartmentService = mock(IApartmentService.class);
        apartmentAnnouncementService = mock(IApartmentAnnouncementService.class);
        userService = mock(IUserService.class);
        jwtTokenService = mock(JwtTokenService.class);
        announcementSpecification = mock(AnnouncementSpecification.class);

        announcementService = new AnnouncementServiceImpl(announcementMapper, announcementRepository, buildingService, apartmentService, apartmentAnnouncementService, userService, jwtTokenService);

        dtoAnnouncementIU = DtoAnnouncementIU.builder()
                .title("Test Announcement")
                .content("This is a test announcement.")
                .createdBy("testUser")
                .buildingId(1L)
                .apartmentIds(List.of(1L, 2L))
                .build();

        dtoAnnouncement = DtoAnnouncement.builder()
                .id(1L)
                .title("Test Announcement")
                .content("This is a test announcement.")
                .createdBy("testUser")
                .buildingId(1L)
                .apartmentIds(List.of(1L, 2L))
                .build();

        building = Building.builder()
                .id(1L)
                .name("Test Building")
                .build();


        announcement = Announcement.builder()
                .id(1L)
                .title("Test Announcement")
                .content("This is a test announcement.")
                .createdBy("testUser")
                .building(building)
                .apartmentAnnouncements(new ArrayList<>())
                .build();

        apartments = List.of(
                Apartment.builder().id(1L).building(building).build(),
                Apartment.builder().id(2L).building(building).build()
        );

    }

    // Test for createAnnouncement method with parameters
    @Test
    public void whenCreateAnnouncementCalledWithParams_thenAnnouncementIsCreated() {
        // Arrange
        String title = "Test Announcement";
        String content = "This is a test announcement.";
        String createdBy = "testUser";
        Long buildingId = 1L;
        List<Long> apartmentIds = List.of(1L, 2L);

        when(buildingService.getBuildingById(1L)).thenReturn(building);

        when(announcementMapper.createAnnouncement(any(DtoAnnouncementIU.class), eq(building))).thenReturn(announcement);
        when(announcementRepository.save(any(Announcement.class))).thenReturn(announcement);


        when(apartmentService.getApartmentById(1L)).thenReturn(apartments.getFirst());
        when(apartmentService.getApartmentById(2L)).thenReturn(apartments.getLast());

        //ACT
        announcementService.createAnnouncement(title, content, createdBy, buildingId, apartmentIds);

        // ASSERT
        verify(buildingService).getBuildingById(1L);
        verify(announcementMapper).createAnnouncement(any(DtoAnnouncementIU.class), eq(building));

        verify(announcementRepository).save(any(Announcement.class));

        verify(apartmentService).getApartmentById(1L);
        verify(apartmentService).getApartmentById(2L);

        verify(apartmentAnnouncementService).createApartmentAnnouncement(announcement, apartments.getFirst());
        verify(apartmentAnnouncementService).createApartmentAnnouncement(announcement, apartments.getLast());
    }
    @Test
    public void whenCreateAnnouncementCalledWithParams_thenBuildingNotFoundExceptionIsThrown() {
        String title = "Test Announcement";
        String content = "This is a test announcement.";
        String createdBy = "testUser";
        Long buildingId = 1L;
        List<Long> apartmentIds = List.of(1L, 2L);

        when(buildingService.getBuildingById(buildingId))
                .thenThrow(new IllegalArgumentException("Building not found"));

        assertThrows(IllegalArgumentException.class, () -> {
            announcementService.createAnnouncement(title, content, createdBy, buildingId, apartmentIds);
        });

        verify(buildingService).getBuildingById(buildingId);
        verifyNoInteractions(announcementMapper, announcementRepository, apartmentService, apartmentAnnouncementService);
    }
    @Test
    public void whenCreateAnnouncementCalledWithParams_thenApartmentNotFoundExceptionIsThrown() {
        String title = "Test Announcement";
        String content = "This is a test announcement.";
        String createdBy = "testUser";
        Long buildingId = 1L;
        List<Long> apartmentIds = List.of(10L, 20L);

        when(buildingService.getBuildingById(buildingId)).thenReturn(building);

        when(announcementMapper.createAnnouncement(any(DtoAnnouncementIU.class), eq(building)))
                .thenReturn(announcement);

        when(announcementRepository.save(any(Announcement.class))).thenReturn(announcement);

        when(apartmentService.getApartmentById(10L)).thenReturn(apartments.getFirst());

        when(apartmentService.getApartmentById(20L))
                .thenThrow(new ApplicationException(new ErrorMessage(MessageType.NOT_FOUND, "Apartment not found with id: 20")));

        assertThrows(ApplicationException.class, () -> {
            announcementService.createAnnouncement(title, content, createdBy, buildingId, apartmentIds);
        });

        verify(buildingService).getBuildingById(buildingId);
        verify(apartmentService).getApartmentById(10L);
        verify(apartmentService).getApartmentById(20L);
        verify(apartmentAnnouncementService).createApartmentAnnouncement(announcement, apartments.getFirst());
        verify(apartmentAnnouncementService, times(1)).createApartmentAnnouncement(any(), any());
    }

    // Test for createAnnouncement method with DtoAnnouncementIU
    @Test
    public void whenCreateAnnouncementCalledWithDto_thenAnnouncementIsCreated() {
        DtoAnnouncement expectedDto = DtoAnnouncement.builder()
                .id(1L)
                .build();

        when(jwtTokenService.findEmailFromToken(token)).thenReturn(email);
        doNothing().when(userService).checkUserIsManagerOfBuilding(email, 1L);

        when(buildingService.getBuildingById(1L)).thenReturn(building);

        when(announcementMapper.createAnnouncement(any(DtoAnnouncementIU.class), eq(building))).thenReturn(announcement);
        when(announcementRepository.save(any(Announcement.class))).thenReturn(announcement);

        when(apartmentService.getApartmentById(1L)).thenReturn(apartments.getFirst());
        when(apartmentService.getApartmentById(2L)).thenReturn(apartments.getLast());

        when(announcementMapper.toDtoAnnouncement(announcement)).thenReturn(expectedDto);

        // ACT
        DtoAnnouncement result = announcementService.createAnnouncement(dtoAnnouncementIU, token);

        // ASSERT
        verify(jwtTokenService).findEmailFromToken(token);
        verify(userService).checkUserIsManagerOfBuilding(email, 1L);
        verify(buildingService).getBuildingById(1L);

        verify(announcementMapper).createAnnouncement(any(DtoAnnouncementIU.class), eq(building));
        verify(announcementRepository).save(any(Announcement.class));

        verify(apartmentService).getApartmentById(1L);
        verify(apartmentService).getApartmentById(2L);

        verify(apartmentAnnouncementService).createApartmentAnnouncement(announcement, apartments.getFirst());
        verify(apartmentAnnouncementService).createApartmentAnnouncement(announcement, apartments.getLast());

        assert result != null;
        assert result.getId().equals(expectedDto.getId());
    }
    @Test
    public void whenCreateAnnouncementCalledWithDto_thenUserIsNotManagerOfBuildingIsThrown() {
        when(jwtTokenService.findEmailFromToken(token)).thenReturn(email);
        doThrow(new ApplicationException(new ErrorMessage(MessageType.UNAUTHORIZED, "User is not a manager of the building with id: 1")))
                .when(userService).checkUserIsManagerOfBuilding(email, 1L);

        assertThrows(ApplicationException.class, () -> {
            announcementService.createAnnouncement(dtoAnnouncementIU, token);
        });

        verify(userService).checkUserIsManagerOfBuilding(email, 1L);
        verifyNoInteractions(buildingService, announcementMapper, announcementRepository, apartmentService, apartmentAnnouncementService);
    }
    @Test
    public void whenCreateAnnouncementCalledWithDto_thenBuildingNotFoundExceptionIsThrown() {
        when(jwtTokenService.findEmailFromToken(token)).thenReturn(email);
        doNothing().when(userService).checkUserIsManagerOfBuilding(email, 1L);

        when(buildingService.getBuildingById(1L))
                .thenThrow(new IllegalArgumentException("Building not found"));

        assertThrows(IllegalArgumentException.class, () -> {
            announcementService.createAnnouncement(dtoAnnouncementIU, token);
        });

        verify(buildingService).getBuildingById(dtoAnnouncementIU.getBuildingId());
        verifyNoInteractions(announcementMapper, announcementRepository, apartmentService, apartmentAnnouncementService);
    }
    @Test
    void whenCreateAnnouncementCalledWithDto_thenApartmentNotFoundExceptionIsThrown() {
        when(jwtTokenService.findEmailFromToken(token)).thenReturn(email);
        doNothing().when(userService).checkUserIsManagerOfBuilding(email, 1L);

        when(buildingService.getBuildingById(1L)).thenReturn(building);

        when(announcementMapper.createAnnouncement(any(DtoAnnouncementIU.class), eq(building)))
                .thenReturn(announcement);

        when(announcementRepository.save(any(Announcement.class))).thenReturn(announcement);

        when(apartmentService.getApartmentById(1L)).thenReturn(apartments.getFirst());

        when(apartmentService.getApartmentById(2L))
                .thenThrow(new ApplicationException(new ErrorMessage(MessageType.NOT_FOUND, "Apartment not found with id: 2")));

        assertThrows(ApplicationException.class, () -> {
            announcementService.createAnnouncement(dtoAnnouncementIU, token);
        });

        verify(buildingService).getBuildingById(dtoAnnouncementIU.getBuildingId());
        verify(apartmentService).getApartmentById(1L);
        verify(apartmentService).getApartmentById(2L);
        verify(apartmentAnnouncementService).createApartmentAnnouncement(announcement, apartments.getFirst());
        verify(apartmentAnnouncementService, times(1)).createApartmentAnnouncement(any(), any());
    }

    // Test for getAnnouncements method
    @Test
    public void whenGetAnnouncements_thenReturnListOfDtoAnnouncements() {
        Page<Announcement> announcementPage = new PageImpl<>(List.of(announcement));

        when(jwtTokenService.findEmailFromToken(token))
                .thenReturn(email);
        doNothing().when(userService)
                .checkUserIsMemberOfBuilding(email, building.getId());

        when(announcementRepository.findAll(any(Specification.class), any(Pageable.class)))
                .thenReturn(announcementPage);


        when(announcementMapper.toDtoAnnouncement(announcement))
                .thenReturn(dtoAnnouncement);

        // Act
        /*Page<DtoAnnouncement> result = announcementService.getAnnouncements(
                token, building.getId(), "test", LocalDateTime.now(), LocalDateTime.now(), "system", 1, 10, "id", "asc"
        );*/

        // Assert

        verify(jwtTokenService).findEmailFromToken(token);
        verify(userService).checkUserIsMemberOfBuilding(email, building.getId());
        verify(announcementRepository).findAll(any(Specification.class), any(Pageable.class));
        verify(announcementMapper).toDtoAnnouncement(announcement);
    }
    /*
    @Test
    public void whenGetAnnouncements_thenUserIsNotMemberOfBuildingIsThrown() {
        when(jwtTokenService.findEmailFromToken(token)).thenReturn(email);
        doThrow(new ApplicationException(new ErrorMessage(MessageType.UNAUTHORIZED, "User is not a member of the building with id: 1")))
                .when(userService).checkUserIsMemberOfBuilding(email, 1L);

        assertThrows(ApplicationException.class, () -> {
            announcementService.getAnnouncements(token, 1L, "test", LocalDateTime.now(), LocalDateTime.now(), "system", 1, 10, "id", "asc");
        });

        verify(userService).checkUserIsMemberOfBuilding(email, 1L);
        verifyNoInteractions(announcementRepository, announcementMapper);
    }
    @Test
    public void whenGetAnnouncements_thenBuildingNotFoundExceptionIsThrown() {
        when(jwtTokenService.findEmailFromToken(token)).thenReturn(email);
        doNothing().when(userService).checkUserIsMemberOfBuilding(email, 1L);

        when(announcementRepository.findAll(any(Specification.class), any(Pageable.class)))
                .thenThrow(new IllegalArgumentException("Building not found"));

        assertThrows(IllegalArgumentException.class, () -> {
            announcementService.getAnnouncements(token, 1L, "test", LocalDateTime.now(), LocalDateTime.now(), "system", 1, 10, "id", "asc");
        });

        verify(announcementRepository).findAll(any(Specification.class), any(Pageable.class));
        verifyNoInteractions(announcementMapper);
    }
*/
    // Test for getAnnouncementById method
    @Test
    public void whenGetAnnouncementById_thenReturnDtoAnnouncement() {
        when(announcementRepository.findById(1L)).thenReturn(java.util.Optional.of(announcement));
        when(jwtTokenService.findEmailFromToken(token)).thenReturn(email);
        doNothing().when(userService).checkUserIsMemberOfBuilding(email, announcement.getBuilding().getId());
        when(announcementMapper.toDtoAnnouncement(announcement)).thenReturn(dtoAnnouncement);

        DtoAnnouncement result = announcementService.getAnnouncementById(1L, 1L, 1L, token);

        verify(announcementRepository).findById(1L);
        verify(jwtTokenService).findEmailFromToken(token);
        verify(userService).checkUserIsMemberOfBuilding(email, announcement.getBuilding().getId());
        verify(announcementMapper).toDtoAnnouncement(announcement);

        assert result != null;
        assert result.getId().equals(dtoAnnouncement.getId());
    }
    @Test
    public void whenGetAnnouncementById_thenAnnouncementNotFoundExceptionIsThrown() {
        when(announcementRepository.findById(1L)).thenReturn(java.util.Optional.empty());

        assertThrows(RuntimeException.class, () -> {
            announcementService.getAnnouncementById(1L, 1L, 1L, token);
        });

        verify(announcementRepository).findById(1L);
        verifyNoInteractions(jwtTokenService, userService, announcementMapper);
    }
    @Test
    public void whenGetAnnouncementById_thenUserIsNotMemberOfBuildingIsThrown() {
        when(announcementRepository.findById(1L)).thenReturn(java.util.Optional.of(announcement));
        when(jwtTokenService.findEmailFromToken(token)).thenReturn(email);
        doThrow(new ApplicationException(new ErrorMessage(MessageType.UNAUTHORIZED, "User is not a member of the building with id: 1")))
                .when(userService).checkUserIsMemberOfBuilding(email, announcement.getBuilding().getId());

        assertThrows(ApplicationException.class, () -> {
            announcementService.getAnnouncementById(1L, 1L, 1L, token);
        });

        verify(announcementRepository).findById(1L);
        verify(userService).checkUserIsMemberOfBuilding(email, announcement.getBuilding().getId());
        verifyNoInteractions(announcementMapper);
    }

    // Test for updateAnnouncement method
    @Test
    public void whenUpdateAnnouncement_thenReturnUpdatedDtoAnnouncement() {
        when(announcementRepository.findById(1L)).thenReturn(java.util.Optional.of(announcement));
        when(jwtTokenService.findEmailFromToken(token)).thenReturn(email);
        doNothing().when(userService).checkUserIsManagerOfBuilding(email, announcement.getBuilding().getId());

        doNothing().when(apartmentAnnouncementService).updateApartmentAnnouncement(announcement, dtoAnnouncementIU.getApartmentIds());
        when(announcementRepository.save(announcement)).thenReturn(announcement);
        when(announcementMapper.toDtoAnnouncement(announcement)).thenReturn(dtoAnnouncement);

        DtoAnnouncement result = announcementService.updateAnnouncement(1L, dtoAnnouncementIU, token);

        verify(announcementRepository).findById(1L);
        verify(jwtTokenService).findEmailFromToken(token);
        verify(userService).checkUserIsManagerOfBuilding(email, announcement.getBuilding().getId());
        verify(apartmentAnnouncementService).updateApartmentAnnouncement(announcement, dtoAnnouncementIU.getApartmentIds());
        verify(announcementRepository).save(announcement);
        verify(announcementMapper).toDtoAnnouncement(announcement);

        assert result != null;
        assert result.getId().equals(dtoAnnouncement.getId());
    }
    @Test
    public void whenUpdateAnnouncement_thenAnnouncementNotFoundExceptionIsThrown() {
        when(announcementRepository.findById(1L)).thenReturn(java.util.Optional.empty());

        assertThrows(RuntimeException.class, () -> {
            announcementService.updateAnnouncement(1L, dtoAnnouncementIU, token);
        });

        verify(announcementRepository).findById(1L);
        verifyNoInteractions(jwtTokenService, userService, apartmentAnnouncementService, announcementMapper);
    }
    @Test
    public void whenUpdateAnnouncement_thenUserIsNotManagerOfBuildingIsThrown() {
        when(announcementRepository.findById(1L)).thenReturn(java.util.Optional.of(announcement));
        when(jwtTokenService.findEmailFromToken(token)).thenReturn(email);
        doThrow(new ApplicationException(new ErrorMessage(MessageType.UNAUTHORIZED, "User is not a manager of the building with id: 1")))
                .when(userService).checkUserIsManagerOfBuilding(email, announcement.getBuilding().getId());

        assertThrows(ApplicationException.class, () -> {
            announcementService.updateAnnouncement(1L, dtoAnnouncementIU, token);
        });

        verify(announcementRepository).findById(1L);
        verify(userService).checkUserIsManagerOfBuilding(email, announcement.getBuilding().getId());
        verifyNoInteractions(apartmentAnnouncementService, announcementMapper);
    }

    // Test for deleteAnnouncement method
    @Test
    public void whenDeleteAnnouncement_thenAnnouncementIsDeleted() {
        when(announcementRepository.findById(1L)).thenReturn(java.util.Optional.of(announcement));
        when(jwtTokenService.findEmailFromToken(token)).thenReturn(email);
        doNothing().when(userService).checkUserIsManagerOfBuilding(email, announcement.getBuilding().getId());

        announcementService.deleteAnnouncement(1L, token);

        verify(announcementRepository).findById(1L);
        verify(jwtTokenService).findEmailFromToken(token);
        verify(userService).checkUserIsManagerOfBuilding(email, announcement.getBuilding().getId());
        verify(announcementRepository).delete(announcement);
    }
    @Test
    public void whenDeleteAnnouncement_thenAnnouncementNotFoundExceptionIsThrown() {
        when(announcementRepository.findById(1L)).thenReturn(java.util.Optional.empty());

        assertThrows(RuntimeException.class, () -> {
            announcementService.deleteAnnouncement(1L, token);
        });

        verify(announcementRepository).findById(1L);
        verifyNoInteractions(jwtTokenService, userService);
    }
    @Test
    public void whenDeleteAnnouncement_thenUserIsNotManagerOfBuildingIsThrown() {
        when(announcementRepository.findById(1L)).thenReturn(java.util.Optional.of(announcement));
        when(jwtTokenService.findEmailFromToken(token)).thenReturn(email);
        doThrow(new ApplicationException(new ErrorMessage(MessageType.UNAUTHORIZED, "User is not a manager of the building with id: 1")))
                .when(userService).checkUserIsManagerOfBuilding(email, announcement.getBuilding().getId());

        assertThrows(ApplicationException.class, () -> {
            announcementService.deleteAnnouncement(1L, token);
        });

        verify(announcementRepository).findById(1L);
        verify(userService).checkUserIsManagerOfBuilding(email, announcement.getBuilding().getId());
    }
}
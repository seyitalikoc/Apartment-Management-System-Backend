package com.seyitkoc.service.base;

import com.seyitkoc.entity.Poll;
import com.seyitkoc.repository.PollRepository;
import com.seyitkoc.specification.PollSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PollBaseService {
    private final PollRepository pollRepository;
    private final PollSpecification pollSpecification;

    public PollBaseService(PollRepository pollRepository, PollSpecification pollSpecification) {
        this.pollRepository = pollRepository;
        this.pollSpecification = pollSpecification;
    }

    public Page<Poll> getAllPollsByBuildingIdAndFilter(
            Long buildingId,String text, LocalDateTime minCreatedAt, LocalDateTime maxCreatedAt, boolean isFinished,
            int page, int size, String sortBy, String sortDirection
    ) {
        Specification<Poll> specification = Specification.where(pollSpecification.byBuildingId(buildingId))
                .and(pollSpecification.byText(text))
                .and(pollSpecification.byMinCreateAt(minCreatedAt))
                .and(pollSpecification.byMaxCreateAt(maxCreatedAt))
                .and(pollSpecification.byIsFinished(isFinished));

        return pollRepository.findAll(specification, PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortDirection), sortBy)));
    }
}

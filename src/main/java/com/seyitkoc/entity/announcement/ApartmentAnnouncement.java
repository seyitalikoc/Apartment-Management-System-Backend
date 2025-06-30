package com.seyitkoc.entity.announcement;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.seyitkoc.entity.apartment.Apartment;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "apartment_announcements")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ApartmentAnnouncement {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonBackReference
    private Apartment apartment;

    @ManyToOne
    @JsonBackReference
    private Announcement announcement;

    @Column(name = "is_read", nullable = false)
    private boolean isRead = false;
}

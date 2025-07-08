package com.seyitkoc.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "apartment_id", nullable = false)
    @JsonBackReference
    private Apartment apartment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "announcement_id", nullable = false)
    @JsonBackReference
    private Announcement announcement;

    @Column(name = "is_read", nullable = false)
    private boolean isRead = false;
}

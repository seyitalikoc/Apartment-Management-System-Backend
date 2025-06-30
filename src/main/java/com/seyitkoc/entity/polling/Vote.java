package com.seyitkoc.entity.polling;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.seyitkoc.entity.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Table(name = "votes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Vote {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "poll_id", nullable = false)
    @JsonBackReference
    private Poll poll;

    @Column(name = "voted_at", nullable = false)
    private LocalDateTime votedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "voter_id", nullable = false)
    @JsonBackReference
    private User voter; // user

    @Column(name = "voter_name", nullable = false)
    private String voterName;

    @Column(name = "voter_apartment_id", nullable = false)
    private Long voterApartmentId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "poll_option_id", nullable = false)
    @JsonBackReference
    private PollOption pollOption;
}

package com.clubapp.userservice.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "teams")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToMany(fetch=FetchType.LAZY,cascade={CascadeType.PERSIST,CascadeType.DETACH,CascadeType.REFRESH,CascadeType.MERGE})
    @JoinTable(name="users_teams", joinColumns=@JoinColumn(name="team_id"), inverseJoinColumns=@JoinColumn(name="user_id"))
    private Set<User> users = new HashSet<>();

}

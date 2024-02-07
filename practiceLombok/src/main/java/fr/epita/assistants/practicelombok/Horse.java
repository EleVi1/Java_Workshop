package fr.epita.assistants.practicelombok;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString (exclude = {"nickname"})
@EqualsAndHashCode(of = {"name", "nickname"})
public class Horse {
    private String name;
    private String nickname;
    private int speed;
}

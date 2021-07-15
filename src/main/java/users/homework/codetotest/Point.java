package users.homework.codetotest;

import lombok.*;

@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Setter
@Getter
@ToString
public class Point {

	float x;
	float y;

	public Point(float x, float y) {
		this.x = x;
		this.y = y;
	}
}

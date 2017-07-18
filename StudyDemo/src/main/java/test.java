import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Osborn on 2017/7/18.
 */
public class test {
	public static final int NUM = 12;
	public static final String STR = "hahah";
	public static final Object OBJ = new Object() {
		@Override
		public String toString() {
			return "haha";
		}
	};

	@Test
	public void say() {
		System.out.println(NUM);
		System.out.println(STR);
		System.out.println(OBJ);

	}

	@Test
	public void fun() {

		Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 0).filter(item->item>=5).findFirst();


	}
}

package prep.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SmallestInteger 
{
	public static void solution(int[] A) {
		Set<Integer> set = new HashSet<>(Arrays.asList(-1 , 2, -3, 4, 4, 2));
		Set<Integer> filterd = set.stream()
								.filter(x->x>2)
								.collect(Collectors.toSet());
		System.out.println(filterd);
		
        Set<Integer> set1 =  Arrays.stream(A)
        					.filter(x->x>3)
        					.collect(Collectors.toSet());
       
        
    }
	
	public static void main(String args[])
	{
		solution(new int[]{1,2,3,4,5});
	}

}

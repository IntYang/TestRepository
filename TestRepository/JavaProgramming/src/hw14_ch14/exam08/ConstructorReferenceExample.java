package hw14_ch14.exam08;

import java.util.function.BiFunction;
import java.util.function.Function;

public class ConstructorReferenceExample {
	Function<String, Member> function1 = Member :: new;
	Member member1 = function1.apply("angel");
	
	BiFunction<String, String, Member> function2 = Member :: new;
	Member member2 = function2.apply("Ω≈√µªÁ", "angel");
}

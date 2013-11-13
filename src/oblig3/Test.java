package oblig3;

public class Test 
{
	public static void main(String[] args)
	{
		SBinTre2<String> tre = SBinTre2.lagTre();
		
		tre.leggInn("hei");
		System.out.println(tre.antall());
	}
}

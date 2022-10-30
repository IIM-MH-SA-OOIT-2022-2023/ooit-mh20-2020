package dodatni_zadatak;

public class zad {

	public static void main(String[] args) {
	
		int dan=28,mes=10,god=2022,b=0,a=10,c=2022;
		System.out.println("Vežbe se održavaju u terminima:");
		for(int i=dan;i<=32;i++) {
				
				if(i==32 && mes==10 && god==2022) {
					i=1;
					mes++;
				}
				else if(i==31 && mes==11 && god==2022) {
					i=1;
					mes++;
				}
				else if(i==32 && mes==12 && god==2022) {
					i=1;
					mes=1;
					god++;
				}
				else if(i==18 && mes==1 && god==2023) {
					break;
				}
				
				a=10;
				c=2022;
				for(b=28;b<40;b=b+7) {
					
					if(b>31 && a==10 && c==2022) {
						b=b-31;
						a++;
					}
					else if(b>30 && a==11 && c==2022) {
						b=b-30;
						a++;
					}
					else if(b>31 && a==12 && c==2022) {
						b=b-31;
						a=1;
						c=2023;
					}
					
					
					if((i==b && mes==a && god==c) && !(b==3 && a==1 && c==2023)) {
						System.out.println(b + "." + a + "." + c + ".");
					}	
			}
				 if(i==25 && mes==12) {
					System.out.println("Srećan Božić!");
				}
				else if(i==1 && mes==1) {
					System.out.println("Srećna Nova godina!");
				}
				else if(i==7 && mes==1) {
					System.out.println("Srećan Božić!");
				}
		}
		
		

	}

}

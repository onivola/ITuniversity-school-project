package aina;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int table[] =  {1,25,68,40,96,60,98,5,26,75,36,24,13,99,12};
		//int tab[] = supindice(table,littletab(table)[0]);
		//int tabcrois[] = tabcroissant(table);
		//affichetab(tabcrois);
		//int[][] tab= gettable();
		//affichetable(tab);
	        
		B B = new B(2007);
		ClasseC c = new ClasseC();
		//c.fonctionx();
		c.affiche();
		ClasseB b = new ClasseB();
		System.out.println(b.i);
		System.out.println(b.f());
		System.out.println(b.g());
		System.out.println(ClasseB.g());
		ClasseA a = (ClasseA) b ;
		//System.out.println(a.i);
		System.out.println(a.f());
		//System.out.println(a.g());
		//System.out.println(ClasseA.g());
			//System.out.println(littletab(table));
		int table[] = new int[100];
		for(int i=0;i<table.length;i++) {
			table[i]=i;
		}
		for(int i=0;i<table.length;i++) {
			if(nbpremier(table[i])) {
			System.out.println("table["+i+"] ="+table[i] + nbpremier(table[i]));
			}
		}
		
		
	}
	public static Boolean nbpremier(int nb) {
		if(nb==0) {
			return false;
		}
		for(int i=2;i<nb;i++) {
			if(nb%i==0) {
				return false;
			}
		}
		return true;
		
	}
	public static int[][] gettable() {
		int ret[][] = new int[12][12];
        
	       // table
	        for(int j=0;j<ret.length;j++) {
              for(int i=0;i<ret[j].length;i++) {
                 ret[j][i] = (j+1)*(i+1);
                
             }
	     }
	        return ret;
		
	}
	public static void affichetable(int[][] ret) {
			       // table
	        for(int j=0;j<ret.length;j++) {
              for(int i=0;i<ret[j].length;i++) {
                 ret[j][i] = (j+1)*(i+1);
                 System.out.println(j+1+"*"+(i+1)+"="+ret[j][i]);
             }
	     }
	       
		
	}
	public static int[] tabcroissant(int[] table) {
		int tab[] = table;
		int[] tabcrois = new int[table.length];
		for(int i=0;i<table.length;i++) {
			tabcrois[i] = littletab(tab)[1];
			tab = supindice(tab,littletab(tab)[0]);
		}
		return tabcrois;
	}
	public static int[] littletab(int[] tab) {
		int little = tab[0];
		int indice = 0;
		for(int j=0;j<tab.length;j++) {
			for(int i=0;i<tab.length;i++) {
				if(little>tab[i]) {
					little = tab[i];
					indice=i;
				}
			}
		}
		int tablittle[] = {indice,little};
		return tablittle;
		
	}
	public static int[] supindice(int[] tab,int indice) {
		int[] tab2 = new int[tab.length-1];
		int i=0;
		int j=0;
		//System.out.println(tab2.length);
		//System.out.println(indice);
		while(j<tab2.length) {
			if(i!=indice) {
			tab2[j]=tab[i];
			i++;
			j++;
			} else if(i==indice) {
				i++;
				
			}
		}
		return tab2;
		
	}
	public static void affichetab(int[] tab) {
		for(int i=0;i<tab.length;i++) {
			System.out.println(tab[i]);
		}
		
	}
	

}

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class LePenduV2  {
	
	public static void main(String[] args) {
		// affichage sur la console d'une cha�ne de caract�res	
		// (non demand� dans le sujet - c'est pour le suivi)
		String valeur = "Jeu du Pendu v2" ;
		System.out.println(valeur);
						
		// D�finition et cr�ation d'un scanner 
		// pour "lire" des valeurs au clavier
		Scanner sc = new Scanner(System.in);
 		
		//***********************************************
		// On remplace la lecture du mot au clavier par l'utilisation d'une liste
		// On pr�cise que son contenu sera des chaines (String)
		List<String> listeMots = new ArrayList<String>();
		
		// On ajoute quelques mots (courts)
		listeMots.add("bar");
		listeMots.add("arc");
		listeMots.add("bouc");
		listeMots.add("mot");
		
		// S�lectionne un mot au "hasard"
		Random rnd = new Random();
		int indiceMot = rnd.nextInt(listeMots.size());
		String motATrouver = listeMots.get(indiceMot);
				
		//***********************************************
						
		// Affichage caract�re par caract�re le mot � trouver
		int indice = 0 ;
		while (indice < motATrouver.length()) {
			System.out.print("*");
			indice++;
		}
		System.out.println();

		// Nombre d'essais
		// initialise le nombre d'essais maxi
		int nbEssaisMaximum = motATrouver.length() * 2;
		System.out.println("Vous aurez "+nbEssaisMaximum+" essais pour trouver le mot de "+motATrouver.length()+" lettres");

		// Cha�ne contenant les lettres jou�es
		String lettresJouees = "";

		// Compteur des essais du joueur
		int nbEssaisJoues = 0;

		// D�claration du compteur de lettres trouv�es avant la boucle afin que la variable soit accessible dans la condition du "do..while"
		int compteurLettresTrouvees; 
		
		// debut de la boucle de jeu
		do {

			//Affiche � l'�cran les lettres d�j� jou�es
			System.out.println("Lettres d�j� jou�es :"+lettresJouees);

			//R�cup�re une lettre au clavier
			System.out.println("Donner une lettre :");
			String lettreFournie = sc.nextLine();
			char lettre = lettreFournie.charAt(0);

			// Ajout de cette lettre � la cha�ne des lettres d�j� jou�es (sans doublons)		
			if (!lettresJouees.contains(Character.toString(lettre))) {
				lettresJouees = lettresJouees+lettre;
			}


			// Affichage caract�re par caract�re le mot � trouver en int�grant la lettre saisie si elle existe
			
			// On initialise le compteur de lettres trouv�es pour chaque essai
			compteurLettresTrouvees = 0;
			
			indice = 0 ;
			while (indice < motATrouver.length()) {
				if (lettresJouees.contains(Character.toString(motATrouver.charAt(indice)))) {
					System.out.print(motATrouver.charAt(indice));
					// On a trouv� une lettre, on la compte
					compteurLettresTrouvees++;
				}
				else {
					System.out.print("*");
				}

				indice++;
			}
			System.out.println();

			// Affichage du nombre de lettres trouv�es
			System.out.println("Nb Lettres trouvees : "+compteurLettresTrouvees);
		
			// Incr�mente le nombre d'essais
			nbEssaisJoues++;
		
		}while(compteurLettresTrouvees != motATrouver.length() && nbEssaisJoues < nbEssaisMaximum);

		// Affichage selon le cas : Gagn� ou perdu...
		if (compteurLettresTrouvees == motATrouver.length()) {
			System.out.println("gagne en "+nbEssaisJoues+" essai(s)");
		}
		else {
			System.out.println("perdu, le mot a trouver etait "+motATrouver);
		}	
		
		
		// lorsque l'on ne l'utilise plus, on ferme le Scanner
		sc.close();
	}
}
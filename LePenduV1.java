import java.util.Scanner;

public class LePenduV1  {
	// ci-dessous le point d'entrée/programme principal
	public static void main(String[] args) {
		// affichage sur la console d'une chaîne de caractères	
		// (non demandé dans le sujet - c'est pour le suivi)
		String valeur = "Jeu du Pendu v1.2" ;
		System.out.println(valeur);
		
		// Définition et création d'un scanner 
		// pour "lire" des valeurs au clavier
		Scanner sc = new Scanner(System.in);

 		//Lit la valeur au clavier
		System.out.println("Donner le mot à trouver :");
		String motATrouver = sc.nextLine();
		
		// Affichage caractère par caractère le mot à trouver
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

		// Chaîne contenant les lettres jouées
		String lettresJouees = "";

		// Compteur des essais du joueur
		int nbEssaisJoues = 0;

		// Déclaration du compteur de lettres trouvées avant la boucle afin que la variable soit accessible dans la condition du "do..while"
		int compteurLettresTrouvees; 
		
		// debut de la boucle de jeu
		do {

			//Affiche à l'écran les lettres déjà jouées
			System.out.println("Lettres déjà jouées :"+lettresJouees);

			//Récupère une lettre au clavier
			System.out.println("Donner une lettre :");
			String lettreFournie = sc.nextLine();
			char lettre = lettreFournie.charAt(0);

			// Ajout de cette lettre à la chaîne des lettres déjà jouées (sans doublons)		
			if (!lettresJouees.contains(Character.toString(lettre))) {
				lettresJouees = lettresJouees+lettre;
			}


			// Affichage caractère par caractère le mot à trouver en intégrant la lettre saisie si elle existe
			
			// On initialise le compteur de lettres trouvées pour chaque essai
			compteurLettresTrouvees = 0;
			
			indice = 0 ;
			while (indice < motATrouver.length()) {
				if (lettresJouees.contains(Character.toString(motATrouver.charAt(indice)))) {
					System.out.print(motATrouver.charAt(indice));
					// On a trouvé une lettre, on la compte
					compteurLettresTrouvees++;
				}
				else {
					System.out.print("*");
				}

				indice++;
			}
			System.out.println();

			// Affichage du nombre de lettres trouvées
			System.out.println("Nb Lettres trouvees : "+compteurLettresTrouvees);
		
			// Incrémente le nombre d'essais
			nbEssaisJoues++;
		
		}while(compteurLettresTrouvees != motATrouver.length() && nbEssaisJoues < nbEssaisMaximum);

		// Affichage selon le cas : Gagné ou perdu...
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
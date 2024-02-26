import java.rmi.Naming; // Importer les classes nécessaires pour RMI
import java.util.Scanner; // Importer la classe Scanner pour la lecture depuis la console

public class clientRMI { // Classe principale du client RMI
    public static void main(String[] args) { 
        try {
            // Récupérer la référence distante à partir du registre RMI
            StringOperations stringOperations = (StringOperations) Naming.lookup("rmi://localhost/StringOperations"); // Rechercher l'objet distant avec le nom "StringOperations" sur le serveur local

            // Demander à l'utilisateur d'entrer une chaîne
            Scanner scanner = new Scanner(System.in); // Créer un objet Scanner pour la lecture depuis la console
            System.out.print("Entrez une chaîne : "); // Demander à l'utilisateur d'entrer une chaîne
            String inputString = scanner.nextLine(); // Lire la chaîne entrée par l'utilisateur

            // Appeler la méthode distante avec la chaîne saisie par l'utilisateur
            String result = stringOperations.convertToUpper(inputString); // Appeler la méthode distante pour convertir la chaîne en majuscules

            // Afficher le résultat
            System.out.println("Résultat de la conversion : " + result); // Afficher le résultat de la conversion
        } catch (Exception e) { // Gérer les exceptions
            System.err.println("Erreur survenue lors de l'appel au serveur : " + e); // Afficher les erreurs
        }
    }
}


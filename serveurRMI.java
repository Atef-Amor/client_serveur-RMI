// Importer les classes nécessaires pour RMI
import java.rmi.Remote; 
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

 // Définir une interface distante
interface StringOperations extends Remote {
    String convertToUpper(String str) throws RemoteException; // Méthode distante
}

// Implémentation de l'interface distante
class StringOperationsImpl extends UnicastRemoteObject implements StringOperations { 
    protected StringOperationsImpl() throws RemoteException { 
        super(); // Appeler le constructeur de la classe parente
    }

    @Override
    public String convertToUpper(String str) throws RemoteException { // Implémenter la méthode distante
        return str.toUpperCase(); // Convertir la chaîne en majuscules
    }
}

public class serveurRMI { // Classe principale du serveur RMI
    public static void main(String[] args) { 
        try {
            // Créer une instance de l'implémentation distante
            StringOperationsImpl stringOperations = new StringOperationsImpl();

            // Publier l'objet distant sur un port
            java.rmi.registry.LocateRegistry.createRegistry(1099); // Créer un registre RMI sur le port 1099(port par defaud du register RMI)
            java.rmi.Naming.rebind("StringOperations", stringOperations); // Lier l'objet distant au nom "StringOperations"

            System.out.println("Serveur RMI prêt."); // Afficher un message lorsque le serveur est prêt
        } catch (Exception e) { // Gérer les exceptions
            System.err.println("Erreur survenue lors du démarrage du serveur : " + e); // Afficher les erreurs
        }
    }
}

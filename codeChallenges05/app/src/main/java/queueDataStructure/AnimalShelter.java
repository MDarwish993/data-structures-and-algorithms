package queueDataStructure;

public class AnimalShelter {
    private PseudoQueue<Animal> animalQueue;

    public AnimalShelter() {
        animalQueue = new PseudoQueue<>();
    }

    // Enqueue an animal (either a cat or a dog) to the shelter.
    public void enqueue(Animal animal) {
        animalQueue.enqueue(animal);
    }

    // Dequeue an animal based on the preference (either "dog" or "cat").
    // Return null if the preference is neither "dog" nor "cat."
    public Animal dequeue(String pref) {
        if (!pref.equals("dog") && !pref.equals("cat")) {
            return null; // Invalid preference
        }

        while (!animalQueue.isEmpty()) {
            Animal currentAnimal = animalQueue.dequeue();
            if (currentAnimal.getSpecies().equals(pref)) {
                return currentAnimal; // Return the preferred animal
            }
        }

        return null; // No animals of the preferred species found
    }
}

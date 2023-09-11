# Challenge 12
#### Implement a Queue using two Stacks
## Picture of whiteboard
<img src="C:\Users\C-ROAD\IdeaProjects\data-structures-and-algorithms\codeChallenges05\app\src\assets\cc12.jpg "/>

### - Initial PseudoQueue Class Methods:
1- enqueue Method:

- Arguments: animal
- animal can be either a dog or a cat object.
- animal must have a species property that is either "cat" or "dog".
- animal must have a name property that is a string.
- This method should add the animal to the shelter's queue in the order it was received.

2- dequeue Method:

- Arguments: pref
- pref can be either "dog" or "cat".
- Return: Either a dog or a cat, based on preference.
- If pref is not "dog" or "cat," return null.
- This method should return the first animal in the queue that matches the preference. If there are no animals of the preferred type in the shelter, return null.
## Solution
public class AnimalShelter {

private PseudoQueue<Animal> animalQueue;

    public AnimalShelter() {
        animalQueue = new PseudoQueue<>();
    }

   
    public void enqueue(Animal animal) {
        animalQueue.enqueue(animal);
    }

    
    public Animal dequeue(String pref) {
        if (!pref.equals("dog") && !pref.equals("cat")) {
            return null;
        }

        while (!animalQueue.isEmpty()) {
            Animal currentAnimal = animalQueue.dequeue();
            if (currentAnimal.getSpecies().equals(pref)) {
                return currentAnimal; 
            }
        }

        return null; 
    }
}

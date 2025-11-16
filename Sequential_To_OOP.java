
/*
Human thinks like algorithm.
For example: Take input to an array. If size exceeds 5 print and flush it

let array;
while(true) {
    int num = prompt("Taking input for array");
    array.push(num);

    if(array.length > 5){
        console.log(array);
        array = []
    }
}

 */

import java.util.ArrayList;
import java.util.Scanner;

public class InputStore {
    private ArrayList<Integer> array = new ArrayList<>();
    public void takingInput(){
        Scanner scanner = new Scanner(System.in);
        Integer input = scanner.nextInt();
        AddToArray(input);
    }
    private void AddToArray(Integer input){
        this.array.add(input);
    }
    private void PrintArray(){
        System.out.println(array);
        array.clear();
    }
}

public void main() {
    InputStore inputStore = new InputStore();
    while(true){
        inputStore.takingInput();
    }
}

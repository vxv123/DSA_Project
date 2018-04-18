/*


 * @author: Wes Holman
 * @version: 2018.01.29

 */
 
 class ListArrayBasedPlus<T> extends ListArrayBased<T>{
 
 
   private void resize(){
      //1 Allocate larger memory
      T temp[] = (T[]) new Object[2*this.items.length];//Creates an array twice the size of the current one
      //2 copy over all references
      for(int i = 0; i < this.items.length; i++){
         temp[i] = this.items[i];
      }
      //3 assign temp to items
      this.items = temp;//Now that the original array is dereferenced, garbage collection can reclaim it as necessary
      return;
   }
   
   public void add(int index, T item){
      if(this.numItems >= this.items.length){
         this.resize();
      }
      super.add(index, item);
      return;
   }
   
   public void reverse(){
      T temp; //Necessary for swapping
      for(int i = 0; i <= this.numItems/2; i++){//Use numItems as stopping criterion, as the array is padded with junk
         temp = items[i];
         items[i] = items[this.numItems-i];
         items[this.numItems-i] = temp;
         //Since items is a protected data field of the superclass, these writing operations are allowed
         //While it's typically better practice to use a class's own methods for getting and setting a data member, those operations are costly in this implementation
         //We save O(n) operations each iteration doing it this way, for a net reduction of O(n^2) to O(n)
      }
      return;
   }
   
   public String toString(){
      if(numItems == 0){
         return "COLLECTION IS EMPTY";
      }
      String output = "";
      for(int i = 0; i < this.numItems - 1; i++){
         //Relies on Object's toString or the subclass's overriden method of toString
         output += items[i].toString() + "\n";
      }
      return output += items[numItems-1].toString();
      
      }
 }
public class DesignMemoryAllocator {
        int [] memory;

        public DesignMemoryAllocator(int n) {
            memory = new int[n];
        }

        public int allocate(int size, int mID) {
            int count=0;
            for(int i=0;i<memory.length;i++){
                if(memory[i] == 0){
                    count++;
                } else{
                    count=0;
                }
                if(size == count){
                    int start = i-size+1;
                    for(int k=start;k<=i;k++){
                        memory[k]= mID;
                    }
                    return start;
                }
            }
            return -1;
        }

        public int freeMemory(int mID) {
            int freed=0;
            for(int i=0;i<memory.length;i++){
                if(memory[i] == mID){
                    memory[i]=0;
                    freed++;
                }
            }
            return freed;
        }
    }
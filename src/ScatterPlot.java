public class ScatterPlot {
    private Pair[] pairs;

    public ScatterPlot(){
        pairs = new Pair[10];
    }

    public Pair[] copy (Pair[] pairs){
        Pair[] copy = new Pair[pairs.length];
        for(int i = 0; i<copy.length; i++){
            copy[i] = pairs[i];
        }
        return copy;
    }

}

/**
 * Sequence Class
 * Created by Devang on 10-Jan-17.
 */
class Sequence{
    int max;
    int seqStart;
    int seqEnd;
    
    public Sequence(){
        max = 0;
        seqStart = 0;
        seqEnd = 0;
    }
    
    public String toString(){
        return "Max: " + this.max + " [From " + this.seqStart + " to " + this.seqEnd + "]";
    }
}
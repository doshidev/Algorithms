import java.util.Arrays;
import java.util.Random;

/**
 * Created by Devang on 07-Jan-17.
 */
public class BoggleBoard {
    public static void main(String[] args) {
        int w = 4;
        int h = 4;
        String s = "mapoeterdenildhc";
        String word = "";
        char[][] visited = newBoard(w, h, 0, null);
        char[][] myBoard = newBoard(w, h, 1, s);
        String[] soln = new String[195];
        soln[0] = "aero";
        soln[1] = "apter";
        soln[2] = "cheero";
        soln[3] = "chine";
        soln[4] = "chirp";
        soln[5] = "deed";
        soln[6] = "deep";
        soln[7] = "den";
        soln[8] = "denier";
        soln[9] = "deter";
        soln[10] = "edema";
        soln[11] = "ended";
        soln[12] = "entame";
        soln[13] = "enteric";
        soln[14] = "erned";
        soln[15] = "eterne";
        soln[16] = "hend";
        soln[17] = "hetaeric";
        soln[18] = "hind";
        soln[19] = "hinter";
        soln[20] = "iched";
        soln[21] = "indeed";
        soln[22] = "intel";
        soln[23] = "leep";
        soln[24] = "lend";
        soln[25] = "mated";
        soln[26] = "meated";
        soln[27] = "medled";
        soln[28] = "meeter";
        soln[29] = "meted";
        soln[30] = "metepa";
        soln[31] = "neat";
        soln[32] = "neem";
        soln[33] = "niche";
        soln[34] = "opened";
        soln[35] = "orient";
        soln[36] = "pated";
        soln[37] = "peat";
        soln[38] = "peen";
        soln[39] = "pend";
        soln[40] = "pened";
        soln[41] = "pentel";
        soln[42] = "poet";
        soln[43] = "pree";
        soln[44] = "prent";
        soln[45] = "pretend";
        soln[46] = "pterin";
        soln[47] = "reamed";
        soln[48] = "reed";
        soln[49] = "reen";
        soln[50] = "rend";
        soln[51] = "rente";
        soln[52] = "rete";
        soln[53] = "rich";
        soln[54] = "rind";
        soln[55] = "rope";
        soln[56] = "tamed";
        soln[57] = "taper";
        soln[58] = "teamed";
        soln[59] = "teem";
        soln[60] = "teene";
        soln[61] = "teer";
        soln[62] = "teld";
        soln[63] = "tended";
        soln[64] = "tern";
        soln[65] = "aper";
        soln[66] = "cheep";
        soln[67] = "chenet";
        soln[68] = "chined";
        soln[69] = "cine";
        soln[70] = "deem";
        soln[71] = "deer";
        soln[72] = "denet";
        soln[73] = "dent";
        soln[74] = "eaten";
        soln[75] = "edenic";
        soln[76] = "enrich";
        soln[77] = "entamed";
        soln[78] = "eric";
        soln[79] = "etape";
        soln[80] = "heed";
        soln[81] = "hent";
        soln[82] = "hete";
        soln[83] = "hint";
        soln[84] = "hire";
        soln[85] = "inch";
        soln[86] = "inept";
        soln[87] = "inter";
        soln[88] = "leer";
        soln[89] = "lent";
        soln[90] = "mater";
        soln[91] = "meddle";
        soln[92] = "meed";
        soln[93] = "meta";
        soln[94] = "meteor";
        soln[95] = "meter";
        soln[96] = "need";
        soln[97] = "neep";
        soln[98] = "niched";
        soln[99] = "opted";
        soln[100] = "oriented";
        soln[101] = "paten";
        soln[102] = "peed";
        soln[103] = "pein";
        soln[104] = "pended";
        soln[105] = "peni";
        soln[106] = "peri";
        soln[107] = "pore";
        soln[108] = "preed";
        soln[109] = "prented";
        soln[110] = "print";
        soln[111] = "ream";
        soln[112] = "reap";
        soln[113] = "reede";
        soln[114] = "rein";
        soln[115] = "rended";
        soln[116] = "rented";
        soln[117] = "reteam";
        soln[118] = "riched";
        soln[119] = "rinded";
        soln[120] = "taed";
        soln[121] = "tape";
        soln[122] = "teaed";
        soln[123] = "teed";
        soln[124] = "teen";
        soln[125] = "teener";
        soln[126] = "teind";
        soln[127] = "tench";
        soln[128] = "tene";
        soln[129] = "terne";
        soln[130] = "apted";
        soln[131] = "cheer";
        soln[132] = "chin";
        soln[133] = "chiro";
        soln[134] = "cire";
        soln[135] = "deen";
        soln[136] = "deet";
        soln[137] = "deni";
        soln[138] = "dented";
        soln[139] = "eater";
        soln[140] = "eine";
        soln[141] = "enriched";
        soln[142] = "enter";
        soln[143] = "erne";
        soln[144] = "eten";
        soln[145] = "held";
        soln[146] = "hented";
        soln[147] = "hetero";
        soln[148] = "hinted";
        soln[149] = "hiree";
        soln[150] = "inched";
        soln[151] = "inro";
        soln[152] = "leed";
        soln[153] = "leet";
        soln[154] = "mate";
        soln[155] = "meat";
        soln[156] = "medle";
        soln[157] = "meet";
        soln[158] = "mete";
        soln[159] = "meteoric";
        soln[160] = "neap";
        soln[161] = "neeld";
        soln[162] = "nete";
        soln[163] = "open";
        soln[164] = "opter";
        soln[165] = "pate";
        soln[166] = "pater";
        soln[167] = "peel";
        soln[168] = "peined";
        soln[169] = "pene";
        soln[170] = "pent";
        soln[171] = "pern";
        soln[172] = "porn";
        soln[173] = "preen";
        soln[174] = "preteen";
        soln[175] = "printed";
        soln[176] = "reame";
        soln[177] = "reate";
        soln[178] = "reel";
        soln[179] = "reined";
        soln[180] = "rent";
        soln[181] = "repo";
        soln[182] = "retem";
        soln[183] = "richen";
        soln[184] = "rine";
        soln[185] = "tame";
        soln[186] = "tapen";
        soln[187] = "team";
        soln[188] = "teel";
        soln[189] = "teend";
        soln[190] = "teenier";
        soln[191] = "teinded";
        soln[192] = "tend";
        soln[193] = "tepa";
        soln[194] = "terned";
    
    
        for(int i = 0; i < h; i++){
            for(int j = 0; j < w; j++){
               boggle(myBoard, visited, word, soln, i, j);
            }
        }
    }
    
    private static void boggle(char[][] board, char[][] visited, String word, String[]soln, int x, int y){
        
        if(visited[x][y] == '1')
            return;
        
        visited[x][y] = '1';
        word += board[x][y];
        
        if(Arrays.asList(soln).contains(word))
            System.out.println(word);
        
        
        int[][] n = new int[8][2];
        n[0][0] = x;
        n[0][1] = y-1; // top
    
        n[1][0] = x;
        n[1][1] = y + 1;   // bottom
    
        n[2][0] = x - 1;
        n[2][1] = y;    // left
    
        n[3][0] = x + 1;
        n[3][1] = y;    // right
    
        n[4][0] = x - 1;
        n[4][1] = y - 1;    // top left
    
        n[5][0] = x + 1;
        n[5][1] = y + 1;    // bottom right
    
        n[6][0] = x - 1;
        n[6][1] = y + 1;    // bottom left
    
        n[7][0] = x + 1;
        n[7][1] = y - 1;    // top right
        
        for(int i = 0; i < 8; i++){
            int x1 = n[i][0];
            int y1 = n[i][1];
            
            if(x1 >= 0 && x1 < board[0].length && y1 >= 0 && y1 < board.length){
                boggle(board, visited, word, soln, x1, y1);
            }
        }
        visited[x][y] = '0';
    }
    
    private static char[][] newBoard(int w, int h, int type, String s){
        char[][] board = new char[h][w];
        char c;
        int p = 0;
        Random r = new Random();
        
        for(int i = 0; i < h; i++){
            for(int j = 0; j < w; j++){
                if (type == 1){
                    if(s.length() == w*h){
                        c = s.toCharArray()[p++];
                    } else {
                        c = (char) (r.nextInt(26) + 97);
                    }
                    board[i][j] = c;
                } else {
                    board[i][j] = '0';
                }
                System.out.print("\t" + board[i][j]);
            }
            System.out.print("\n");
        }
        System.out.println();
        return board;
    }
}

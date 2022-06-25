import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        int n, m;

        char[][] mp = new char[110][110];

        n = scn.nextInt();
        m = scn.nextInt();

        for(int i = 0; i < n; ++i)
        {
            for(int j = 0; j < m; ++j)
            {
                mp[j][i] = scn.next().charAt(0);

                if(mp[j][i] == '.') {

                    if((j+i)%2 == 0) {

                        mp[j][i]='B';
                    }
                    else {

                        mp[j][i]='W';
                    }
                }
            }
        }

        for(int i = 0; i < n; ++i)
        {
            for(int j=0; j < m; ++j){

                System.out.print(mp[j][i]);
            }
            System.out.println();
        }
    }
}

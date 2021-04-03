using System;
using System.Text;

class Program {
    static void Main(string[] args) {
        int N = int.Parse(Console.ReadLine());

        int count = HanNumber(N);
    }

    static int HanNumber(int a) {
        int han_check = 0, count = 0;

        if (a > 100) {
            count += 99;
        }else {
            return a;
        }

        for (int i = 100; i <= a; i++) {
            if((i/10 - (i/100 * 10)) == 0) {
                continue;
            }else if((i/10 - (i/100 * 10)) == (i%10 - (i/10 - (i/100 * 10)))) {
                count++;
            }

        }
        
        return count;
    }
}
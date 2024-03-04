#include <stdio.h>

long long mysteryFunc(...){
    // complete me ...
}

int main(int argc, char *argv[])
{
    long long res = 0;
    for (int i = 0; i < argc; i++)
    {
        res += mysteryFunc(argv[i]);
    }
    printf("%lld\n", res);
    return 0;
}
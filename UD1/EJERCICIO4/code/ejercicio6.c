// ejercicio6
// Joseba Martinez
#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <sys/wait.h>

void main (){
    pid_t pid,pid2;
    int status;

    //Primer Hijo
    if ((pid=fork()) == -1){
        exit(-1);
    }else if (pid==0){
        printf("Soy el hijo 1, mi padre es PID=%d, yo soy PID=%d\n",getppid(),getpid());
    }else{
        // Segundo Hijo
        if ((pid2=fork()) == -1){
            exit(-1);
        }else if(pid2==0){
            printf("Soy el hijo 2, mi padre es PID=%d, yo soy PID=%d\n",getppid(),getpid());

            // Tercer Hijo
            if((pid=fork()) == -1){
                exit(-1);
            }else if (pid == 0){
                printf("Soy el hijo 3, mi padre es PID=%d, yo soy PID=%d\n",getppid(),getpid());
            }else{
            }
        }else{
            waitpid(pid,&status,0);
        }
    }
    exit(0);
}
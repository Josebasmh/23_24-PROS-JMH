// ejercicio5
// Joseba Martinez
#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <sys/wait.h>

void main (){
    pid_t pid;
    int status;

    // Bucle para todos esos hijos
    for (size_t i=1;i>=4;i++){
        if ((pid=fork())==-1){
            exit(-1);
        }else if ((pid=fork())==0){
            printf("Soy el hijo %d, mi padre es %d",getpid(),getppid());
            pid = fork();
        }else{
            waitpid(pid,&status,0);
            printf("Soy el padre %d, mi padre es %d",getpid(),getppid());
        }
    }
    exit(0);
}
// ejercicio5
// Joseba Martinez
#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <sys/wait.h>

void main (){
    pid_t pid;
    int status;
    int n=3; //Numero de procesos del programa
    
    for (int i=0;i<n;i++){
        if ((pid=fork()) == -1){
            exit(-1);
        }else if (pid==0){
            printf("Soy el hijo %d, mi padre es %d \n",getpid(),getppid());
        }else{
            waitpid(pid,&status,0);
            exit(0);
        }
    } 
}
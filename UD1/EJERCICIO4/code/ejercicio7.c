// ejercicio7
// Joseba Martinez
#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <sys/wait.h>
int num=6;
int status;
pid_t pid, Hijo_pid;

void main (){
    printf("Valor inicial de la variable: %d\n",num);
    pid=fork();
    // Hijo
    if (pid == -1){
        exit(-1);
    }else if(pid == 0){
        num=num-5;
        printf("Variable en Proceso Hijo: %d\n",num);
    }else{

        // Padre
        waitpid(pid,&status,0);
        num=num+5;
        printf("Variable en Proceso Padre: %d\n",num);
    }
    exit(0);
}
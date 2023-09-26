// ejercicio8
// Joseba Martinez

#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <sys/wait.h>

void main (){
    pid_t pid;
    int status;
    int fd1[2],fd2[2];
    char buffer[25];

    pipe(fd1);
    pid = fork();
    
    switch (pid){
    case -1:
        printf("No se a podido crear el proceso hijo\n");
        exit(-1);
        break;
    
    case 0:
        printf("\tEl HIJO recibe mensaje de abuelo: %d",read(fd1[0],buffer,19));

        pipe(fd2);
        pid = fork();
        switch (pid){
        case -1:
            printf("No se a podido crear el proceso nieto\n");
            exit(-1);
            break;
        
        // Nieto
        case 0:
            printf("\t\tEl NIETO recibe mensaje del padre: %d",read(fd2[0],buffer,19));
            write(fd2[1],"Saludo del NIETO..",18);
            printf("\t\tEl NIETO envía mensaje al HIJO......");

        // Hijo
        default:
            printf("\tEl HIJO envía un mensaje al NIETO.......");
            write(fd2[0],"Saludo del PADRE..",19);
            waitpid(pid,&status,0);
            printf("\tEl HIJO recibe mensaje de su hijo: %d",read(fd2[1],buffer,19));
            write(fd1[1],"Saludo del HIJO..",18);
            printf("\tEl HIJO envía un mensaje al ABUELO......");
            break;
        }

    // Padre
    default:
        printf("El ABUELO envía un mensaje al HIJO......");
        write(fd1[0],"Saludo del ABUELO..",19);
        waitpid(pid,&status,0);
        printf("El ABUELO recibe un mensaje del HIJO: %d",read(fd1[1],buffer,19));
        break;
    }
    exit(0);
}
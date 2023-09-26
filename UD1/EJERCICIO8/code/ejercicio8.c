// ejercicio8
// Joseba Martinez

#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <sys/wait.h>

void main (){
    pid_t pid,pid2;
    int status;
    int fd1[2];
    int fd2[2];
    char buffer[25];

    pipe(fd1);
    pipe(fd2);
    pid = fork();
    
    switch (pid){
    case -1:
        printf("No se a podido crear el proceso hijo\n");
        exit(-1);
        break;
    
    case 0:
        read(fd1[0],buffer,19);
        printf("\tEl HIJO recibe mensaje de abuelo: %s\n",buffer);

        pid2 = fork();
        switch (pid2){
        case -1:
            printf("No se a podido crear el proceso nieto\n");
            exit(-1);
            break;
        
        // Nieto
        case 0:
            read(fd2[0],buffer,18);
            printf("\t\tEl NIETO recibe mensaje del padre: %s\n",buffer);
            write(fd1[1],"Saludo del NIETO..",18);
            printf("\t\tEl NIETO envía mensaje al HIJO......\n");

        // Hijo
        default:
            printf("\tEl HIJO envía un mensaje al NIETO.......\n");
            write(fd2[1],"Saludo del PADRE..\n",18);
            waitpid(pid,&status,0);
            read(fd1[0],buffer,18);
            printf("\tEl HIJO recibe mensaje de su hijo: %s\n",buffer);
            write(fd2[1],"Saludo del HIJO..\n",18);
            printf("\tEl HIJO envía un mensaje al ABUELO......\n");
            break;
        }

    // Padre
    default:
        printf("El ABUELO envía un mensaje al HIJO......\n");
        write(fd1[1],"Saludo del ABUELO..\n",19);
        waitpid(pid,&status,0);
        read(fd2[0],buffer,18);
        printf("El ABUELO recibe un mensaje del HIJO: %s\n",buffer);
        break;
    }
    exit(0);
}

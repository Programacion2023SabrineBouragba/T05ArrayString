# UD05ArrayString

## Tarea 1

![image](https://github.com/Programacion2023SabrineBouragba/UD05ArrayString/assets/146069628/a8aa6986-a73d-4280-96a3-335ead2d3fb5)

- a. Tiene 10 índices
- b. datos tipo entero
- c. el array[7] devuelve el valor 103
- d. introduciendo: array[4] y devolvera el valor 0
- e. nos permite almacenar una secuencia de valores todos del mismo tipo
- f. array[9] = 2;
- g. array[1] + array[5] nos devolvería la suma de sus valores que sería 38 + 14= 52
- h. suma 1 al contenido de la celda 6, solo que lo suma después
- i. daría error porque no existe el array[14]


![image](https://github.com/Programacion2023SabrineBouragba/UD05ArrayString/assets/146069628/bfd0eb27-2a41-4dc2-a0a4-36632128f8e7)
- a. el array tiene 3 índices/celdas
- b. el índice superior es 0, porque no se le han asignado valores
c. 


![image](https://github.com/Programacion2023SabrineBouragba/UD05ArrayString/assets/146069628/083d91c2-ae42-4a3f-817d-5905099a54e0)

- Las incorrectas son:
- (-1), porque no los valores van de 0 a n-1
- (25), porque se pasa del valor establecido, iria de 0 a 24
- (1.2), no se admiten valores dobles dentro del array


![image](https://github.com/Programacion2023SabrineBouragba/UD05ArrayString/assets/146069628/869ff5b5-2a85-4e89-bc66-d3b0d0960033)

- [71, 0, 0, 0, 71, 23, 42]

/*
array [2+2]= array [4]
array [indice-3]= array[0]
*/


![image](https://github.com/Programacion2023SabrineBouragba/UD05ArrayString/assets/146069628/ebdbb3aa-6a7d-4b82-a1f5-76d86604e2dd)

- array[0.21, 4.31, 9.28, 0.0]

- posición 3 valor 0.0
- posición 2 valor 9.28 /*(3-1)*/
/*3=3-2*/
- posición 1 valor 4.31 /*(1)*/


![image](https://github.com/Programacion2023SabrineBouragba/UD05ArrayString/assets/146069628/66f87cdd-4356-4ee8-b1ed-9061e3194309)

- double array[0.0, 0.0, 0.0, 0.0]

- [5.2, 10.0, 51.5, 0.0]

- array[3]= array[2] + array[1] /*valor de la celda 2 sumada a la celda 1*/
- array[3]= 61.5


![image](https://github.com/Programacion2023SabrineBouragba/UD05ArrayString/assets/146069628/977e6c41-411e-4660-9ccd-7a8d06a97765)

- char[] dam= {'D', 'A', 'M'};

- a. el array tiene 3 índices/celdas
- b. dam[2]= 'A'
- c. dam[3]= 'M'


![image](https://github.com/Programacion2023SabrineBouragba/UD05ArrayString/assets/146069628/26ce2424-7e6c-45c2-b3e6-e49c182ce822)

- otra manera de iniciarlo sería esta:
![image](https://github.com/Programacion2023SabrineBouragba/UD05ArrayString/assets/146069628/e5b0acfc-72e0-41d8-bb48-a686acd4ebdc)


![image](https://github.com/Programacion2023SabrineBouragba/UD05ArrayString/assets/146069628/9b4dc235-f4a0-423e-9f77-8f004148f51c)

- imprime lo siguiente:
![image](https://github.com/Programacion2023SabrineBouragba/UD05ArrayString/assets/146069628/31d27198-7f72-4657-a966-4bb57221a4b9)




## **Tarea 4**  *Arrays multidimensionales*

![image](https://github.com/Programacion2023SabrineBouragba/UD05ArrayString/assets/146069628/50e9cedd-b6b7-4d00-b1d1-987023043294)


- a. grandeTable[5] [3];
- b. int[][] grandeTable= new int[6][4];

![image](https://github.com/Programacion2023SabrineBouragba/UD05ArrayString/assets/146069628/7e5b7578-7ff0-4b33-b70c-c0c054ad4bd4)

-a. fila 1(java empieza en 0, por lo que seria la segunda fila), columna 2(java empieza por 0, por lo que es la columna 3), el valor es de 4.


![image](https://github.com/Programacion2023SabrineBouragba/UD05ArrayString/assets/146069628/4f8e26de-7322-46fa-a285-8865aeb7b2ff)

- a.
  - i.  matriz[0][2]= 4
  - ii.  matriz[1][1]= 2
  - iii.  matriz[2][5]= error porque en la fila 2 (empezando por 0) no hay columna 5, solo hay           4(java empieza desde 0 a contar)
  - iv.  matriz[3][0]= error, porque no existe la fila 3
- b. matriz[3][], porque tiene 3 filas, pero de diferente tamaño, eso se tiene que declarar a parte
- c. 
    - matriz[0]= [3]  --> 3 elementos la fila 0
    - matriz[1]= [2]  --> 2 elementos la fila 1
    - matriz[2]= [5]  --> 5 elementos la fila 2
    - se puede utilizar este for para recorrer cada fila y te va mostrando el valor de las           columnas que tiene -->
      - for (int i=0;i<array.length;i++){ //total filas
            for(int j=0;j<array[i].length;j++){ //total columna actual
                System.out.print(array[i][j]);
            }
            System.out.println();


- e. int[][] matriz= { {1,9,4}, {0,2}, {0,1,2,3,4} };
        for (int i=0;i<matriz.length;i++){//total filas
            System.out.print("Fila " + i + " [ ");
            for(int j=0;j<matriz[i].length;j++){//total columna actual
                System.out.print(matriz[i][j] + " ");

            }
            System.out.print("]");
            System.out.println();
        }



  ![image](https://github.com/Programacion2023SabrineBouragba/UD05ArrayString/assets/146069628/9c374ee4-251d-4240-a82c-a666463b57a4)


- 4. int int2D[][]= new int[5][10];
        for (int i=0;i<int2D.length;i++){//total filas
            System.out.print(" [ ");
            for(int j=0;j<int2D[i].length;j++){//total columna actual
                System.out.print(int2D[i][j] + " ");
            }
            System.out.print("]");
            System.out.println();
        }

     
![image](https://github.com/Programacion2023SabrineBouragba/UD05ArrayString/assets/146069628/be4dc678-87f6-478e-a495-e5430189eeff)



- 5. int int2D[][]= {{1,2,3}, {2,3,1}, {4,2,7}};
        for (int i=0;i<int2D.length;i++){//total filas
            for(int j=0;j<int2D[i].length;j++){//total columna actual
                int2D[i][j]= int2D[i][j]*2;
                System.out.print(int2D[i][j] + " ");
            }
            System.out.println();
        }


     ![image](https://github.com/Programacion2023SabrineBouragba/UD05ArrayString/assets/146069628/568814f5-0e35-44cb-bc6d-8da70a867e95)




![image](https://github.com/Programacion2023SabrineBouragba/UD05ArrayString/assets/146069628/2b5ae2a3-dd6e-49d7-a37f-02b2232105e0)

- for(int i=0; i< matriz.length; i++){
            if (matriz[i]== null){
                System.out.println("Fila vacía");
            }else{
                for (int j=0; j<matriz[i].length; j++){
                    System.out.print(matriz[i][j] + " ");
                }
                System.out.println();
            }
        }

  ![image](https://github.com/Programacion2023SabrineBouragba/UD05ArrayString/assets/146069628/44d9822e-7e3b-463e-bcb3-5315a0af0fcf)

![image](https://github.com/Programacion2023SabrineBouragba/UD05ArrayString/assets/146069628/6b176e5e-4f1b-4d05-9f7b-3e1c8b25954a)

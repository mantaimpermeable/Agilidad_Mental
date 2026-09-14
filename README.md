# Programa para agilidad mental personal (sin nombre)
Este programa te da una fecha con dia/mes/año aleatoria y tienes que calcular tu mismo que dia de
la semana fue, esto esta pensado como programa personal para practicar el calculo mental

## Caracteristicas del programa 

- Seccion principal en la que te preguntan por una fecha y te dicen si tu eleccion es correcta
- Medicion de tiempo, guardar record
- Media de tiempo de los ultimos n juegos
- Menu para posibles mas juegos

## Utilizacion de la imagen docker

En el dockerfile esta la ruta del volumen --> app/storage , aqui se guardan los intentos
de las diferentes partidas, para que los datos persistan al cierre de un contenedor tienes que hacer lo siguiente:
<ol>
<li>Hacer un push de la imagen en: "Tengo que crearme cuenta de dockerhub"</li>
<li> Opcion de volumen con nombre:
    <ul>
    <li>docker run -it --rm -v fechas-datos:/app/storage a.mental:v01</li>
    </ul>    
</li>
<li> Opcion de bind mount:
    <ul>
    <li>mkdir -p storage</li>
    <li>docker run -it --rm -v "$(pwd)/storage:/app/storage" a.mental:v01</li>
    </ul>
</li>
<li>Usar la aplicacion</li>
</ol>

- **docker run crea un contenedor a partir de la imagen que has descargado**
- **-it es una flag que te abre la terminal para que interactues con el contenedor**
- **--rm es otra flag que borra el contenedor una vez lo pares**
- **-v tiene como parametro el volumen en el que se guardan los datos para que persistan a las sesiones, bind mount --> <RUTA_LOCAL>:<RUTA_CONTENEDOR>; cuando usas un volumen con nombre simplemente pones el nombre y se guarda en algun lugar de docker, pero con el bind mount tienes que tener el directorio creado y se guardaran alli los datos, aunque el programa permite ver estadisticas esta es una buena opcion para ver como se guardan los datos aunque es opcional**

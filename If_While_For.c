//Esta es una prueba para verificar las estructuras de control

//if-else, while, for

int x;                         

int funcion1(){ //deberia dar error, pues debe haber una expresion
  
  if () {
    x= a+b;
  }else{ 
    x= a+b;
  }  
 
  if (x==2) {
    x= a+b;
  }else{ 
    x= a+b;
  }         

  if if (X< 3) { //deberia dar error por doble if
    x= a+b;
  }else{ 
    x= a+b;
  }    
        
  if (y>=0) { 
    x= a+b;
  }else{ 
    x= a+b;
  }else {
    x= x*8;
  } //deberia dar error por doble uso de else 

  if x==2 {  //deberia dar error por expresion fuera de parentesis
    x= a+b;
  }else{ 
    x= a+b;
  }      
        
    
if (x==4){                  //deberia aceptar if anidados y cualquier tipo de expresion dentro de ( )
                
	if (x<= 7){
					
		x= a+b;
				
	}
                
	else {
					
		x--;
				
	}
		
}else
 { 
			
	x;
		
}

        


for ( ) {
  x= a+b;
}  //deberia dar error pues no hay expresiones en parentesis

       
for (x=0;  ) {   //error pues hay solamente una expresion
  x= a+b;
}
        
for (x=0, x<10 , x++) {   //error pues hay solamente una expresion
  x= a+b;
}
   
 
for (x=1;x<2;x++){
	x= a+b; 
	break;
}

       

while (a==1) {
    x= a+b;
}  //debe dar error falta expresion
        
while (x=1 {
    x= a+b;
}  //debe dar error falta parentesis
      

while ((!f)||(x<2)) { 

	x= a+b; 
	x--; 
	continue; 
	break;} 

}
 // el del fin de la funcion

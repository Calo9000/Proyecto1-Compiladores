section .data
a dd 0.0
b dd 0.0
g dd 0
x dd 0
y dd 0
global main 

section .text
main:
mov b, x		;asignacion
cmp b, 10
jl label1

label1:
cmp b, 10
jl label1		;si no se cumple la condicion, vuelve a ejecutar
ret
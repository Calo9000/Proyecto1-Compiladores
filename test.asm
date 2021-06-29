section .data
b dd 
c dd 
x dd 
y dd 
global main 

section .text
main:
mov rax, z		;suma o resta
mov rbx, 2
add rax, rbx
mov rcx, rax
mov y, rcx		;asignacion
mov a, (resultado de funcion)		;asignacion
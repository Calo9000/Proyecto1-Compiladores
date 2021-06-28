section .data
a dd 0
x dd 0
y dd 0
global main 

section .text
main:
mov y, 10
cmp x, y
jl label1

label1:
mov rax, x
add rax, 1
mov x, rax
cmp x, y
jl label1		;si no se cumple la condicion, vuelve a ejecutar
ret
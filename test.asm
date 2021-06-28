section .data
a dd 0
x dd 0
y dd 0
global main 

section .text
main:
cmp x, y
jl label1
cmp x, y
je label2

label1:
mov rax, x
add rax, 1
mov x, rax
ret

label2:
mov rax, x
sub rax, 1
mov x, rax
ret
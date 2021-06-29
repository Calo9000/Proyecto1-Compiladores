section .data
a dd 0
x dd 0
y dd 0
global main 

section .text
main:
mov rax, b
mov rbx, z
add rax, rbx
mov rcx, rax
mov y, rcx
section .data
a dd 0
x dd 0
y dd 0
global main 

section .text
main:
cmp x, y
jl label1	;if
jge label2	;else

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
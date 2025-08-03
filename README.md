
# ⚡Programa para calcular Campo Elétrico - Cap. 22, Problema 9 (Física)

Este projeto implementa uma interface gráfica em Java (usando Swing) que simula o cálculo do **campo elétrico resultante** gerado por duas partículas carregadas em um ponto \( P \) no plano cartesiano. O problema é baseado no **Capítulo 22 - Problema 9** do livro de física **H A L L I D A Y & R E S N I C K VOL.3 (9ª Edição)**.

---

## 📚 Enunciado do Exercício

> A Fig. 22-32 mostra duas partículas carregadas mantidas fixas no eixo x:  
> -q = -3,20 × 10⁻¹⁹ C no ponto x = -3,00 m  
> +q = +3,20 × 10⁻¹⁹ C no ponto x = +3,00 m  
>
> Determine:  
> (a) o **módulo**  
> (b) a **orientação** (em relação ao semieixo x positivo) do campo elétrico no ponto P,  
> para o qual y = 4,00 m.

---

## 🖥️ Funcionalidades

- Interface gráfica simples e intuitiva.
- Permite entrada manual de:
  - Posições das partículas no eixo X
  - Valores das cargas (positiva ou negativa)
  - Coordenadas X e Y do ponto P
- Calcula:
  - O **módulo** do vetor campo elétrico resultante em \( P \)
  - O **ângulo** do vetor em relação ao eixo X positivo
- Mostra o resultado com precisão científica.
- Possui botão de **limpar campos** e visualização do **enunciado**.

---

## 🧪 Tecnologias Utilizadas

- Java 8+  
- Biblioteca gráfica Swing (padrão no Java SE)  
- NetBeans ou qualquer outro IDE compatível

---

## 📦 Como Executar

1. Clone ou baixe este repositório.
2. Importe o projeto para seu IDE Java favorito (recomenda-se o **NetBeans**).
3. Compile e execute a classe `TrabalhoFisica_2.java`.
4. Preencha os campos na interface e clique em **"Calcular"** para ver o resultado.

---

## 📁 Estrutura do Projeto

```
/src/com/mycompany/trabalhofisica_2/
│
├── TrabalhoFisica_2.java       # Classe principal (main)
├── Tela.java                   # Interface gráfica e lógica de cálculo
├── Ponto.java                  # Representa um ponto no plano
└── Vetor.java                  # Representa o vetor campo elétrico
```

---

## ✅ Exemplo de Uso

Para os dados padrão do exercício:

- Partícula 1: x = -3.00 m, carga = -3.20e-19 C  
- Partícula 2: x = +3.00 m, carga = +3.20e-19 C  
- Ponto P: x = 0, y = 4.00 m  

A aplicação calcula e exibe:

```
Módulo do campo elétrico: 6.40e+00 N/C
Ângulo: 90.00°
```

*(Exemplo ilustrativo)*

---

## 🧠 Conceitos Envolvidos

- Campo elétrico gerado por uma carga pontual:
  	E = k × |q| / r², onde:
  - *E* é o módulo do campo elétrico (N/C)
  - *k* é a constante eletrostática (8,99 × 10⁹ N·m²/C²)
  - *q* é o valor da carga
  - *r* é a distância entre a carga e o ponto P
- Superposição vetorial de campos elétricos
- Trigonometria para ângulos no plano cartesiano
- Interface gráfica com `JFrame`, `JPanel`, `JTextField`, `JButton`, `JOptionPane`

---

---

## 👨‍💻 Autor

Desenvolvido por: Gabriel Henrique 
Curso: Física / Computação — Unespar - Apucarana

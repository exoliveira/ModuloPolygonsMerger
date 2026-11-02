## Requirements
- Polygon is made of clusters
- clusters are made of points
- points have coordinates
- clusters can be shared
- clusters must be ordered
- points must be ordered

## Algorithm
- Criar novo cluster ao iniciar poly
- Iterando por pontos
  - Se não der colisão
    - Inserir no cluster
  - Se der colisão:
    - Tem que saber a qual cluster pertence. Chamado cluster A
    -  Criar novo cluster X
    -  Enquanto tiver colisão
          - Remover o ponto da cluster A
          - Inserir ponto no novo cluster X
    - Se tiver mais pontos no cluster A
      - Criar cluster B
      - Enquanto tiver outros pontos no cluster A
        - Remover do cluster A e inserir no B
    - Adicionar cluster X nos 2 poligonos
    - Adicionar cluster B, se foi criado, no outro Poly
    - Adicionar cluster X no poly em questão
    - criar novo cluster Z e faze-lo o cluster default
		

		
	
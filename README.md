# LP2FinalProject

Projeto Final LP2 - Media Player com Java

Este projeto foi modelado e implementado por Jonathan Rocha de Almeida e Pedro Henrique Bezerra Cavalcante.

Por questões de limitação de tempo e por conta da inesperada redefinição dos requisitos do sistema às vésperas da entrega do mesmo nem todos os requisitos poderam ser atendidos de forma plena.

O player por nós implementado tem as seguintes funcionalidades/características:
	- Possui interface visual.
	- Controla o login de usuários como requisitado:
		- Usuários comuns podem adicionar músicas e diretórios.
		- Apenas usuários VIPs podem cadastrar playlists e outros usuários.
		- Existe um usuario "admin" que possui permissões de VIP.
	- Realiza plenamente a persistência dos dados carregados nele: usuários, músicas, playlists e diretórios.
	- Permite a adição tanto de arquivos de música individuais como de pastas inteiras.
	- Permite tocar playlists personalizadas ou toda a biblioteca disponível.
	- Permite a visualização das músicas e playslists na interface visual.
	- Permite criar e editar playlists.
	- Permite o pular para próxima música e volta à música anterior.

	Extra:
	- Faz uso da classe Thread para permitir a utilização do sistema enquanto a música é tocada.

Como mencionado anteriormente, nem todas as funcionalidade requisitadas foram implementadas, pois dermos prioridade às funcionalidade essenciais de um player de música. Não foram implementadas:
	- O autocompletar na busca por músicas (implementamos um JComboBox que consideramos igualmente eficiente na tela de Gerenciamento de Playlist).
	- A árvore patricia.

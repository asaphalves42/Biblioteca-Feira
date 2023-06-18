
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[autor](
	[id] [int] NOT NULL,
	[nome] [varchar](50) NULL,
	[morada] [varchar](50) NULL,
	[data_nascimento] [datetime] NULL,
 CONSTRAINT [autor_pk] PRIMARY KEY CLUSTERED
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[categoria]    Script Date: 31/05/2023 21:12:05 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[categoria](
	[id] [int] NOT NULL,
	[nome] [varchar](100) NULL,
 CONSTRAINT [categoria_pk] PRIMARY KEY CLUSTERED
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[produto]    Script Date: 31/05/2023 21:12:05 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[produto](
	[id] [int] NOT NULL,
	[titulo] [varchar](100) NOT NULL,
	[quantidade] [int] NOT NULL,
	[id_autor] [int] NOT NULL,
	[id_categoria] [int] NOT NULL,
	[data_publicacao] [datetime] NOT NULL,
	[faixa_etaria] [varchar](20) NOT NULL,
	[editora] [varchar](100) NOT NULL,
	[subtitulo] [varchar](100) NULL,
	[isbn] [varchar](50) NULL,
	[paginas] [int] NULL,
	[capitulos] [int] NULL,
	[tipo] [varchar](10) NULL,
 CONSTRAINT [produto_pk] PRIMARY KEY CLUSTERED
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[reserva]    Script Date: 31/05/2023 21:12:05 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[reserva](
	[id] [int] NOT NULL,
	[id_socio] [int] NULL,
	[data_inicio] [datetime] NULL,
	[data_fim] [datetime] NULL,
 CONSTRAINT [reserva_pk] PRIMARY KEY CLUSTERED
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[reserva_produtos]    Script Date: 31/05/2023 21:12:05 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[reserva_produtos](
	[id_reserva] [int] NULL,
	[id_produto] [int] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[socio]    Script Date: 31/05/2023 21:12:05 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[socio](
	[id] [int] NOT NULL,
	[nome] [varchar](50) NULL,
	[morada] [varchar](50) NULL,
	[data_nascimento] [datetime] NULL,
	[telefone] [int] NULL,
 CONSTRAINT [socio_pk] PRIMARY KEY CLUSTERED
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[produto]  WITH CHECK ADD FOREIGN KEY([id_autor])
REFERENCES [dbo].[autor] ([id])
GO
ALTER TABLE [dbo].[produto]  WITH CHECK ADD FOREIGN KEY([id_categoria])
REFERENCES [dbo].[categoria] ([id])
GO
ALTER TABLE [dbo].[reserva]  WITH CHECK ADD FOREIGN KEY([id_socio])
REFERENCES [dbo].[socio] ([id])
GO
ALTER TABLE [dbo].[reserva_produtos]  WITH CHECK ADD FOREIGN KEY([id_produto])
REFERENCES [dbo].[produto] ([id])
GO
ALTER TABLE [dbo].[reserva_produtos]  WITH CHECK ADD FOREIGN KEY([id_reserva])
REFERENCES [dbo].[reserva] ([id])
GO
/****** Object:  Table [dbo].[tipo_produto]    Script Date: 17/06/2023 14:30:14 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[tipo_produto](
	[id] [int] NOT NULL,
	[nome] [varchar](100) NULL,
 CONSTRAINT [pk_tipo_produto] PRIMARY KEY CLUSTERED
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
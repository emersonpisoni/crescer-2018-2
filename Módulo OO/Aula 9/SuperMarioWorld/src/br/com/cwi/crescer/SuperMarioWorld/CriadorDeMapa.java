package br.com.cwi.crescer.SuperMarioWorld;

import br.com.cwi.crescer.SuperMarioWorld.Elementos.Elemento;
import br.com.cwi.crescer.SuperMarioWorld.Elementos.Obstaculos.Cano;
import br.com.cwi.crescer.SuperMarioWorld.Herois.Heroi;

public class CriadorDeMapa {

    private Elemento[] mapa;
    private Elemento elemento;
    private Heroi heroi;
    private Cano cano;
    private String itemEquipado;
    private int moedasArrecadadas;

    public CriadorDeMapa(int tamanhoDoMapa) {
        this.mapa = new Elemento[tamanhoDoMapa];
    }

    public void adicionarElemento(Elemento elemento, int posicao) throws PosicaoOcupadaException {

        if (this.mapa[posicao] != null) {
            throw new PosicaoOcupadaException();
        } else {
            this.elemento = elemento;
            this.mapa[posicao] = elemento;
        }
        if (elemento.getNomeNoMapa() == "|") {
            this.cano = (Cano) elemento;
        }
    }

    public void adicionarHeroi(Heroi heroi, int posicao) throws HeroiJaAdicionadoException {

        if (this.heroi != null) {
            throw new HeroiJaAdicionadoException();
        }
        if (this.mapa[posicao] == null) {
            this.heroi = heroi;
            this.mapa[posicao] = heroi;
        }
    }

    public String mostrarMapa() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < mapa.length; i++) {
            if (mapa[i] == null) {
                stringBuilder.append("|");
                stringBuilder.append(" ");
            } else {
                stringBuilder.append("|");
                stringBuilder.append(mapa[i].getNomeNoMapa());
            }
        }
        stringBuilder.append("|");
        return stringBuilder.toString();
    }

    public void percorrerMapa() {
        for (int i = 0; i < mapa.length - 1; i++) {
            if (mapa[i] == heroi) {
                if (mapa[i + 1] == null) {
                    avancaHeroi(i, 1);
                } else if (mapa[i + 1] != null) {
                    if (proximaElemento(i, 1) == "C") {
                        if (mapa[mapa.length - 1] == null) {
                            mapa[i + 1] = null;
                            itemEquipado = "C";
                            mapa[mapa.length - 1] = heroi;
                        } else {
                            equipaEAvanca(i, "C");
                        }
                    } else if (proximaElemento(i, 1) == "F") {
                        equipaEAvanca(i, "F");
                    } else if (proximaElemento(i, 1) == "G") {
                        mataInimigo(i, 10);
                    } else if (proximaElemento(i, 1) == "K") {
                        mataInimigo(i, 20);
                    } else if (proximaElemento(i, 1) == "P") {
                        if (itemEquipado == "F") {
                            mataInimigo(i, 50);
                        }
                    } else if ((proximaElemento(i, 1) == "O")) {
                        if (!((i + 1) == mapa.length - 1) && mapa[i + 2] == null) {
                            if (itemEquipado == "C") {
                                mapa[i] = null;
                                mapa[i + 2] = heroi;
                            }
                        }
                    } else if (proximaElemento(i, 1) == "X") {
                        if (!((i + 1) == mapa.length - 1) && mapa[i + 2] != null && (proximaElemento(i, 2) == "O" || proximaElemento(i, 2) == "G" || proximaElemento(i, 2) == "K" || proximaElemento(i, 2) == "P")) {
                            if (proximaElemento(i, 2) == "O") {
                                if (!((i + 2) == mapa.length - 1) && mapa[i + 3] == null) {
                                    if (itemEquipado == "C") {
                                        mapa[i] = null;
                                        mapa[i + 3] = heroi;
                                    }
                                }
                            } else if (proximaElemento(i, 2) == "G") {
                                pulaObstaculo(i, 2);
                                moedasArrecadadas += 10;
                            } else if (proximaElemento(i, 2) == "K") {
                                pulaObstaculo(i, 2);
                                moedasArrecadadas += 15;
                            } else if (proximaElemento(i, 2) == "P") {
                                if (itemEquipado == "F") {
                                    pulaObstaculo(i, 2);
                                    moedasArrecadadas += 50;
                                }
                                if (itemEquipado == "C" && !((i + 2) == mapa.length - 1) && mapa[i + 3] == null) {
                                    pulaObstaculo(i, 2);
                                }
                            }
                        } else if (!((i + 2) == mapa.length - 1) && mapa[i + 3] == null) {
                            if (heroi.getNomeNoMapa() == "M") {
                                if (i == 0) ;
                                else if (!(i == 0) && (mapa[i - 1] == null)) {
                                    pulaObstaculo(i, 3);
                                }
                            }
                            if (heroi.getNomeNoMapa() == "L") {
                                pulaObstaculo(i, 3);
                            }
                        } else if (!((i + 3) == mapa.length - 1) && mapa[i + 4] == null) {
                            if (heroi.getNomeNoMapa() == "M") {
                                if (i == 0 || i == 1) ;
                                else if (mapa[i - 1] == null && (mapa[i - 2] == null)) {
                                    pulaObstaculo(i, 4);
                                }
                            }
                            if (heroi.getNomeNoMapa() == "L") {
                                pulaObstaculo(i, 4);
                            }
                        } else if (!((i + 4) == mapa.length - 1) && mapa[i + 5] == null) {
                            if (heroi.getNomeNoMapa() == "M") {
                                if (i == 0 || i == 1 || i == 2) ;
                                else if (mapa[i - 1] == null && mapa[i - 2] == null && mapa[i - 2] == null) {
                                    pulaObstaculo(i, 5);
                                }
                            }
                            if (heroi.getNomeNoMapa() == "L") {
                                if (i == 0) ;
                                else if (mapa[i - 1] == null) {
                                    pulaObstaculo(i, 5);
                                }
                            }
                        } else if (!((i + 1) == mapa.length - 1) && mapa[i + 2] == null) {
                            mapa[i] = null;
                            mapa[i + 2] = heroi;
                        } else if (!((i + 2) == mapa.length - 1) && mapa[i + 3] == null) {
                            if (heroi.getNomeNoMapa() == "M") {
                                if (i == 0) ;
                                else if (!(i == 0) && (mapa[i - 1] == null)) {
                                    pulaObstaculo(i, 3);
                                }
                            }
                            if (heroi.getNomeNoMapa() == "L") {
                                pulaObstaculo(i, 3);
                            }

                        } else if (!((i + 3) == mapa.length - 1) && mapa[i + 4] == null) {
                            if (heroi.getNomeNoMapa() == "M") {
                                if (i == 0 || i == 1) ;
                                else if (mapa[i - 1] == null && (mapa[i - 2] == null)) {
                                    pulaObstaculo(i, 4);
                                }
                            }
                            if (heroi.getNomeNoMapa() == "L") {
                                pulaObstaculo(i, 4);
                            }
                        } else if (!((i + 4) == mapa.length - 1) && mapa[i + 5] == null) {
                            if (heroi.getNomeNoMapa() == "M") {
                                if (i == 0 || i == 1 || i == 2) ;
                                else if (mapa[i - 1] == null && mapa[i - 2] == null && mapa[i - 2] == null) {
                                    pulaObstaculo(i, 5);
                                }
                            }
                            if (heroi.getNomeNoMapa() == "L") {
                                if (i == 0) ;
                                else if (mapa[i - 1] == null) {
                                    pulaObstaculo(i, 5);
                                }
                            }
                        }
                    } else if ((mapa[i + 1].getNomeNoMapa() == "|")) {
                        if (!((i + 1) == mapa.length - 1) && mapa[i + 2] == null) {
                            if (heroi.getNomeNoMapa() == "M") {
                                if (buscaAlturaDoCano() == 0) {
                                    pulaObstaculo(i, 2);
                                } else if (buscaAlturaDoCano() == 1 && i != 0) {
                                    if (mapa[i - 1] == null) {
                                        pulaObstaculo(i, 2);
                                    }
                                }
                                if (buscaAlturaDoCano() == 1 && (i == 0)) ;
                                if (buscaAlturaDoCano() == 2 && (i == 0 || i == 1)) ;
                            }
                            if (heroi.getNomeNoMapa() == "L") {
                                if (buscaAlturaDoCano() == 0 || buscaAlturaDoCano() == 1) {
                                    mapa[i] = null;
                                    mapa[i + 2] = heroi;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void avancaHeroi(int i, int casa) {
        mapa[i] = null;
        mapa[i + casa] = heroi;
    }

    public int buscaAlturaDoCano() {
        return this.cano.getAlturaDoCano();
    }

    public void equipaEAvanca(int i, String item) {
        avancaHeroi(i, 1);
        itemEquipado = item;
    }

    public void mataInimigo(int i, int moedas) {
        avancaHeroi(i, 1);
        moedasArrecadadas += moedas;
    }

    public String proximaElemento(int i, int posicao) {
        return mapa[i + posicao].getNomeNoMapa();
    }

    public void pulaObstaculo(int i, int tamanho) {
        mapa[i] = null;
        mapa[i + tamanho] = heroi;
    }

    public Elemento[] getMapa() {
        return mapa;
    }

    public int getMoedasArrecadadas() {
        return moedasArrecadadas;
    }
}
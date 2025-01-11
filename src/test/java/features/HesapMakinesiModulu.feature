Feature: Hesap Makinesi Modul Testleri

  @1
  Scenario: SENARYO01 %5 faiz orani ile 100 TL'lik yatirimin 1 yil sonundaki degerini hesaplama
    Given Calculator Sayfasi Acilir
    Given Yatirim tutari 100 ve faiz oranı %5 olarak verilir
    And Faiz orani 1 ile carpilir
    Then Sonucun 0.05 x 1 geldigi gorulur
    And Sonuc bir ile toplanir
    Then Sonucun 0.05 + 1 geldigi gorulur







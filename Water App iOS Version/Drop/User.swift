//
//  User.swift
//  ThirstQuencher
//
//  Created by Claire
//

import UIKit

class User: NSObject {
    private let name, id, password: String
    private let accountType: AccountType
    
    init(name: String, id: String, password: String, accountType: AccountType) {
        self.name = name
        self.id = id
        self.password = password
        self.accountType = accountType
    }
    
    func getName() -> String {
        return name
    }
    
    func getID() -> String {
        return id
    }
    
    func getPassword() -> String {
        return password
    }
    
    func getAccountType() -> AccountType {
        return accountType
    }
    
}

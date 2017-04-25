//
//  Model.swift
//  Drop
//
//  Created by Claire
//

import Foundation
import UIKit

class Model {
    static let sharedInstance = Model()
    
    private var users = [String: User]()
    private var sourceReports = [SourceReport]()
    
    private var currentUser: User?
    
    private init() {addUser(name: "Test User", id: "username", password: "password", accountType: AccountType.USER)}
    
    func addUser(name: String, id: String, password: String, accountType: AccountType) -> Bool {
        
        let newUser = User(name: name, id: id, password: password, accountType: accountType)
        if (users[id] == nil) {
            users[id] = newUser
            return true
        } else {
            return false
        }
 
    }
    
    func checkUser(id: String, password: String) -> String {
        if (users[id] == nil) {
            return "Username does not exist"
        } else if (users[id]!.getPassword() != password) {
            return "Password does not exist"
        } else {
            currentUser = users[id]
            return "Login Succeeded"
        }
        
    }
    
    func addNewReport(date: Date, location: String, waterType: String, waterCondition: String) -> Bool {
        let newReport = SourceReport(date: date, number: (sourceReports.count + 1), name: currentUser!.getName(), location: location, waterType: waterType, waterCondition: waterCondition)
        sourceReports.append(newReport)
        return true
    }
    
    func logout() {
        currentUser = nil
    }
    
    func getCurrentUserName() -> String {
        return currentUser!.getName()
    }
    
    func getNewSourceReportNumber() -> Int {
        return sourceReports.count + 1
    }
}

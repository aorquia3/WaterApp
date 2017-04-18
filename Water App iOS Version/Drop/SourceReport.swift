//
//  SourceReport.swift
//  ThirstQuencher
//
//  Created by Claire
//

import UIKit

class SourceReport: NSObject {
    private let name, location, waterType, waterCondition: String
    private let date: Date
    private let number: Int
    
    init(date: Date, number: Int, name: String, location: String, waterType: String, waterCondition: String) {
        self.date = date
        self.number = number
        self.name = name
        self.location = location
        self.waterType = waterType
        self.waterCondition = waterCondition
    }
    
    func getDate() -> Date {
        return date
    }
    
    func getNum() -> Int {
        return number
    }
    
    func getName() -> String {
        return name
    }
    
    func getLocation() -> String {
        return location
    }
    
    func getWaterType() -> String {
        return waterType
    }
    
    func getWaterCondition() -> String {
        return waterCondition
    }

}

import React from 'react'

function Table({
    data,
    columns
}) {
    return (
        <>
            <table>
                <thead>
                    <tr>
                        {columns?.map((column, index) => (
                            <th key={index}>{column}</th>
                        ))}
                    </tr>
                </thead>
                <tbody>
                
                    {
                        data && data.length > 0 ? (
                        data?.map((row, index) => (
                        <tr key={index}>
                            {columns?.map((column, index) => (
                                <td key={index}>{row[column]}</td>
                            ))}
                        </tr>
                    ))):
                    <tr>
                        <td colSpan="7">No data found...  </td>
                    </tr>
                 }
                
                </tbody>
            </table>
        </>
    )
}

export default Table
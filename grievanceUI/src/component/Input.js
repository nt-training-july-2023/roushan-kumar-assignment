import React from 'react'

function Input({
    id,
    name,
    className,
    onClick,
    type,
    value,
    placeholder,
    onChange,
}) {
    return (
        <input
            id={id}
            name={name}
            className={className}
            onClick={onClick}
            type={type}
            value={value}
            onChange={onChange}
            placeholder={placeholder}
        >
           
        </input>
    )
}

export default Input